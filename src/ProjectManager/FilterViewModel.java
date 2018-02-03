package ProjectManager;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
 
public class FilterViewModel {
 
    private static final String footerMessage = "Total %d Users";
    private ViewFilter projectFilter = new ViewFilter();
    List<Project> currentProject = ViewProject.getAllProjects();
 
    public ViewFilter getProjectFilter(){
    	return projectFilter;
    }
 
    public ListModel<Project> getProjectModel() {
        return new ListModelList<Project>(currentProject);
    }
     
    public String getFooter() {
        return String.format(footerMessage, currentProject.size());
    }
 
    @Command
    @NotifyChange({"projectModel","footer"})
    public void changeFilter(){
    	currentProject = ViewProject.getFilterProject(projectFilter);
    }
}