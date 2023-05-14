package view;

import app.DBApp;
import exceptions.DBAppException;

public class DatabaseManager  {
//	TitleBox titleBox = new TitleBox();
//	Wrapper queryWrapper = new Wrapper(Pos.CENTER);
//	Wrapper tableWrapper = new Wrapper(Pos.TOP_CENTER);

//	public void start(Stage primaryStage) {
//		AppBorder border = new AppBorder(titleBox, queryWrapper, tableWrapper);
//		Scene root = new Scene(border, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
//		primaryStage.setScene(root);
//		primaryStage.setResizable(false);
//		primaryStage.show();
//	}

	public static void main(String[] args) throws DBAppException {
//		launch(args);


		DBApp app = new DBApp();
		StringBuffer s = new StringBuffer();

		//OR (l=u AnD wejo=vfkm and t=1)
		//c=oo OR f=1 AND p=0 OR I=2 AND R=09 AND 1=1
		s.append("INSERT INTO employees (id, name, salary)\n" +
				"VALUES (1, 'John Doe', 5000);");
//		s.append("select abc,d,f,t FROM tttt where b=bk or f=0 AND 1=1;");
//		s.append("DELETE FROM employees WHERE salary < 5000 and a>4;");
//s.append("CREATE INDEX idx_customers ON customers (last_name, first_name);\n");
//s.append("CREATE TABLE employees (\n" +
//		"  employee_id INT PRIMARY KEY," +
//		"id INT" +
//		");");

//		s.append("UPDATE employees\n" +
//				"SET salary = 5000 , l =587" +
//				"WHERE department = 'IT';");
//		""; select * from fv;CREATE TABLE employees (\n" +
//				"    id INT PRIMARY KEY,\n" +
//				"    name VARCHAR(50),\n" +
//				"    age INT,\n" +
//				"    salary DECIMAL(10, 2)\n" +
//				");");
		app.parseSQL(s);

	}

}
