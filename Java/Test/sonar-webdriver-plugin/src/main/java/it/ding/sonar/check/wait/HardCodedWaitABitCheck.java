package it.ding.sonar.check.wait;

import static it.ding.sonar.data.CommonData.HARD_CODED_WAITABIT_CHECK_KEY;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;

@Rule(key = HARD_CODED_WAITABIT_CHECK_KEY)
public class HardCodedWaitABitCheck extends BaseTreeVisitor implements JavaFileScanner {

	private static final String WAITABIT = "waitABit";
	private JavaFileScannerContext context;

	@Override
	public void scanFile(JavaFileScannerContext context) {
		this.context = context;

		scan(context.getTree());
	}

	@Override
	public void visitIdentifier(IdentifierTree tree) {

		String methodName = tree.name();
		if (methodName.equals(WAITABIT)) {
			context.reportIssue(this, tree, "Avoid using hard coded waitABit, use explicit wait instead");
		}
		super.visitIdentifier(tree);

	}

}
