package database.com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import database.com.vti.entity.Account;

public interface IAccountService {
	public List<Account> getListAccounts()
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException;

	public Account getAccountByID(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	public Boolean isAccNameExists(String name) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, Exception;

	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException;

	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException;

	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException;

	public boolean updateByUserName(int id, String newUserName) throws ClassNotFoundException, SQLException;

	public boolean updateByFullName(int id, String newFullName) throws ClassNotFoundException, SQLException;

	public boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException;

	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException;

	public boolean isAccIdExists(int id) throws ClassNotFoundException, SQLException, IOException;

}
