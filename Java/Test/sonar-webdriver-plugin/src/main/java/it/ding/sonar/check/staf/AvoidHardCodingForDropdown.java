package it.ding.sonar.check.staf;


import static it.ding.sonar.data.CommonData.AVOID_HARD_CODING_DROPDOWN;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.check.Priority;

@Rule(key = AVOID_HARD_CODING_DROPDOWN, priority = Priority.MAJOR)
public class AvoidHardCodingForDropdown extends BaseTreeVisitor implements JavaFileScanner {
	
    private JavaFileScannerContext context;
    private static final String METHOD_NAME = "selectByVisibleText";
    private static final String METHOD_NAME1 = "selectByValue";
    private static final String METHOD_NAME2 = "selectByIndex";
    
    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;

        scan(context.getTree());
    }

	
    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {
        if (!tree.methodSelect().is(Tree.Kind.IDENTIFIER)) {
            MemberSelectExpressionTree memberSelectExpressionTree = ((MemberSelectExpressionTree) tree.methodSelect());

           String methodName = memberSelectExpressionTree.identifier().name();
           if ((METHOD_NAME.equals(methodName)) ||(METHOD_NAME1.equals(methodName))||(METHOD_NAME2.equals(methodName))) {
            	if((tree.arguments().get(0).is(Tree.Kind.STRING_LITERAL))||(tree.arguments().get(0).is(Tree.Kind.INT_LITERAL))) {
                context.reportIssue(this, tree, "Avoid hard coding for dropdown, either read data from cucumber or data.xml");
            }
            }
        }
        
        super.visitMethodInvocation(tree);
          
    }

}

