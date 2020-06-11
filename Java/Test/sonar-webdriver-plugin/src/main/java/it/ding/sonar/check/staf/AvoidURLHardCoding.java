package it.ding.sonar.check.staf;

import static it.ding.sonar.data.CommonData.HARD_CODED_URL_CHECK_KEY;

import it.ding.sonar.check.Base;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = HARD_CODED_URL_CHECK_KEY)
public class AvoidURLHardCoding extends Base {

    private static final String METHOD_NAME = "get";
    
    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {
        JavaFileScannerContext context = getContext(); 	         

        if (!tree.methodSelect().is(Tree.Kind.IDENTIFIER)) {
            MemberSelectExpressionTree memberSelectExpressionTree = ((MemberSelectExpressionTree) tree.methodSelect());
            
            String methodName = memberSelectExpressionTree.identifier().name();
            
            if (METHOD_NAME.equals(methodName)) {
            	
            	if((tree.arguments().get(0).is(Tree.Kind.STRING_LITERAL))){
                context.reportIssue(this, tree, "Avoid using hard coded url");
            	}
            }
        }
        super.visitMethodInvocation(tree);
    }

}
