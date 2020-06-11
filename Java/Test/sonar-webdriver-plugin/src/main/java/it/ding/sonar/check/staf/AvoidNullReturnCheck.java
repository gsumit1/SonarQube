package it.ding.sonar.check.staf;


import static it.ding.sonar.data.CommonData.AVOID_NULL_RETURN;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.ReturnStatementTree;
import org.sonar.check.Priority;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = AVOID_NULL_RETURN, priority = Priority.MAJOR)
public class AvoidNullReturnCheck extends BaseTreeVisitor implements JavaFileScanner {
	
    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;

        scan(context.getTree());
    }

	
    @Override
    public void visitReturnStatement(ReturnStatementTree tree) {
        if (returnIsNull(tree)) {
        	context.reportIssue(this, tree, "Avoid using null return, use return webElementFacade instead");        	      
        }
    }

    private boolean returnIsNull(final ReturnStatementTree tree) {
        final ExpressionTree returnValue = tree.expression();
        System.out.println(returnValue);
        return (returnValue != null) && (Kind.NULL_LITERAL == returnValue.kind());
    }
        
}

