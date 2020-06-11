package it.ding.sonar.check.staf;


import static it.ding.sonar.data.CommonData.AVOID_HARD_CODING_TXTBOX;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.check.Priority;

@Rule(key = AVOID_HARD_CODING_TXTBOX, priority = Priority.MAJOR)

public class AvoidHardCodingForTextBox extends BaseTreeVisitor implements JavaFileScanner {
	
    private JavaFileScannerContext context;
    private static final String METHOD_NAME = "sendKeys";
    private static final String METHOD_NAME1 = "type";
      
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
            if ((METHOD_NAME.equals(methodName)) ||(METHOD_NAME1.equals(methodName))) {
            	if(tree.arguments().get(0).is(Tree.Kind.STRING_LITERAL)) {
                context.reportIssue(this, tree, "Avoid hard coding for text box, either read data from cucumber or data.xml");
            }
            }
        }
        
        super.visitMethodInvocation(tree);
  
    }

}

