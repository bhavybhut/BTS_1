package admin;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
 
import admin.User;
import admin.ViewUser;
 
public class FilterViewModel {
 
    private static final String footerMessage = "Total %d Users";
    private ViewFilter userFilter = new ViewFilter();
    List<User> currentUser = ViewUser.getAllUsers();
    
 
    public ViewFilter getUserFilter() {
        return userFilter;
    }
 
    public ListModel<User> getUserModel() {
        return new ListModelList<User>(currentUser);
    }
     
    public String getFooter() {
        return String.format(footerMessage, currentUser.size());
    }
 
    @Command
    @NotifyChange({"userModel", "footer"})
    public void changeFilter() {
        currentUser = ViewUser.getFilterUsers(userFilter);
    }
    
}