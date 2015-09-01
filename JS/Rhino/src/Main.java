import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Main {

	public static void main(String[] args) {
		Context cx = Context.enter();
		try {
			Scriptable scope = cx.initStandardObjects();

			// Build the script
			String script = ""
					+ "Baz = Packages.java.io; "
					+ "langPack = Packages.java.lang;"
					+ "var file = Baz;"
					+ "var filename = \"foo.txt\";"
					+ "var writer = Baz.PrintWriter(filename,\"UTF-8\");"
					+ "var readOnlyFileName = \"ReadOnly.txt\";"
					+ "var fileReader = Baz.File(readOnlyFileName);"
					+ "var sys = langPack.System;"
					+ "if(fileReader.exists() && !fileReader.isDirectory()) "
					+ "{ sys.out.println(\"File Found\"); }"
					+ "else"
					+ "{sys.out.println(\"File Not Found \");}"
					+ "writer.println(\"The first line\");" + "writer.close();";

			// Execute the script
			Object obj = cx
					.evaluateString(scope, script, "TestScript", 1, null);
			System.out.println("Object: " + obj);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Context.exit();
		}
	}
}
