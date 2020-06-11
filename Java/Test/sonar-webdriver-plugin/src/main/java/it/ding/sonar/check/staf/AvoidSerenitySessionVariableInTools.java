package it.ding.sonar.check.staf;


import static it.ding.sonar.data.CommonData.AVOID_SERENITY_SESSION_VARIABLE_IN_TOOL;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.check.Priority;

@Rule(key = AVOID_SERENITY_SESSION_VARIABLE_IN_TOOL, priority = Priority.MINOR)
public class AvoidSerenitySessionVariableInTools extends BaseTreeVisitor implements JavaFileScanner {
	
    private JavaFileScannerContext context;
    private static final String METHOD_NAME = "setSessionVariable";
    private static final String METHOD_NAME1 = "sessionVariableCalled";
    
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
            	
                context.reportIssue(this, tree, "Avoid using Serenity SessionVariable in tools project instead only use only in test project");
            
            }
        }
        
        super.visitMethodInvocation(tree);
        
        
        
    }

}

