import java.io.File;
import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filename= "D:\\3rd Year\\Compiler\\AntlrProjects\\ParserANT\\src\\input";
		File file = new File(filename);
		FileInputStream fis=null;
		
		try{
			fis=new FileInputStream(file);
			ANTLRInputStream input=new ANTLRInputStream(fis);
			bitcounterLexer lexer=new bitcounterLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			bitcounterParser parser=new bitcounterParser(tokens);
			parser.num();
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}

	}

}
