package it.ding.sonar.check.staf;

import static it.ding.sonar.data.CommonData.AVOID_XPATH_CREATION_IN_STEPS;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.check.Priority;

@Rule(key = AVOID_XPATH_CREATION_IN_STEPS, priority = Priority.MAJOR)
public class AvoidXPathCreationInSteps extends BaseTreeVisitor implements JavaFileScanner {
	
    private JavaFileScannerContext context;
    private static final String METHOD_NAME = "xpath";
      
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
             if (METHOD_NAME.equals(methodName)) {
                context.reportIssue(this, tree, "Avoid xpath creation in step class, either use webElement from page class or create in page class");         
        }
        
        super.visitMethodInvocation(tree);
        }}
                
    }
