package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testDelete();
		// testSearch();
		// findById();
		//testHtml();
		testUpdate();

	}

	private static void testHtml() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean = model.authenticcate("aaa", "aaa");
		System.out.print(bean.getId());
		System.out.print(bean.getFirstName());
		System.out.print(bean.getLastName());
		System.out.print(bean.getLoginId());
		System.out.print(bean.getPassword());
		System.out.println(bean.getAddress());

	}

	private static void findById() throws Exception {
		UserModel mod = new UserModel();
		UserBean bean = mod.findById(1);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getAddress());

		} else {
			System.out.println("Id does not exist");
		}

	}

	private static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(9);
		bean.setFirstName("Ajay");
		bean.setLastName("Jain");
		bean.setLoginId("Ajay@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("LIG");
        UserModel model = new UserModel();
        model.update(bean);

	}

	private static void testSearch() throws Exception {
		UserModel model = new UserModel();

		List list = model.search();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			UserBean bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print(bean.getFirstName());
			System.out.print(bean.getLastName());
			System.out.print(bean.getLoginId());
			System.out.print(bean.getPassword());
			System.out.println(bean.getAddress());
		}
	}

	private static void testDelete() throws Exception {
		UserBean bean = new UserBean();

		UserModel Model = new UserModel();
		Model.delete(2);
		System.out.println("uuj");

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstName("Adesh");
		bean.setLastName("Parteti");
		bean.setLoginId("aaa");
		bean.setPassword("aaa");
		bean.setAddress("Jabalpur");
		UserModel mod = new UserModel();
		mod.add(bean);

	}

}
