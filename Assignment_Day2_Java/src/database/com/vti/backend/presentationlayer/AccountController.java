package database.com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.backend.businesslayer.AccountService;
import database.com.vti.backend.businesslayer.IAccountService;
import database.com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}

	public List<Account> getListAccounts()
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {

		return accountService.getListAccounts();
	}

	public Account getAccountByID(int id) throws Exception {
		try {
			return accountService.getAccountByID(id);
		} catch (Exception e) {
			return null;
		}

	}

	public boolean createAccount(Account acc, int depId, int posId)
			throws ClassNotFoundException, SQLException, Exception {

		if (accountService.isAccNameExists(acc.getUsername())) {
			return false;
		} else {
			return accountService.createAccount(acc, depId, posId);
		}
	}

	public Boolean isAccNameExists(String name) throws FileNotFoundException, IOException, Exception {

		return accountService.isAccNameExists(name);

	}

	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException {

		return accountService.updateByEmai(id, newEmail);

	}

	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException {

		return accountService.updateByUserName(id, newUserName);

	}

	public boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {

		return accountService.updateByFullName(id, newFullName);

	}

	public boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {

		return accountService.updateByDepId(id, idDep);
	}

	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {

		return accountService.updateByPosId(id, idPos);
	}

	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {

		return accountService.delAccByID(ID);
	}

}
