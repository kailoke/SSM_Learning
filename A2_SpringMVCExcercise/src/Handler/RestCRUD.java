package Handler;

import Dao.AccountDao;
import Dao.UserDao;
import domain.Account;
import domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
public class RestCRUD {
    /**
     * list all user
     *
     * @param userDao static user data
     * @param map     MV
     * @return MV
     */
    @RequestMapping(path = "/listAllUsers", method = RequestMethod.GET)
    public String listAllUsers(@Qualifier("userDao") UserDao userDao, ModelMap map) {
        System.out.println("listUser");

        // obtain users
        Collection<User> users = userDao.getUsers();
        // deposit
        map.put("users", users);
        return "list";
    }

    /**
     * obtain accounts for account_candidate in inputUser.jsp
     * @param model mv
     * @return mv
     */
    @RequestMapping(path = "/inputUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        System.out.println("inputUser");

        // obtain accounts
        Collection<Account> accounts = AccountDao.getAccounts();
        // deposit data
        model.addAttribute("accounts", accounts);

        // 设置回显数据：空
        model.addAttribute("user", new User());
        return "inputUser";
    }

    @RequestMapping(path = "/inputUser", method = RequestMethod.POST)
    public String postUser(User user) { // POJO 映射
        System.out.println("postUser");

        UserDao.save(user);
        // redirect to listAllUsers
        return "redirect:/listAllUsers";
    }

    @RequestMapping(path = "/listAllUser/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("deleteUser");

        UserDao.delete(id);
        return "redirect:/listAllUsers";
    }

    @RequestMapping(path = "/inputUser/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Map<String,Object> map) {
        System.out.println("obtainUser");

        User user = UserDao.get(id);
        map.put("user",user);

        Collection<Account> accounts = AccountDao.getAccounts();
        map.put("accounts", accounts);
        return "inputUser";
    }

    @RequestMapping(path = "/inputUser", method = RequestMethod.PUT)
    public String update(User user) {
        System.out.println("updateUser");

        UserDao.save(user);

        return "redirect:/listAllUsers";
    }
}
