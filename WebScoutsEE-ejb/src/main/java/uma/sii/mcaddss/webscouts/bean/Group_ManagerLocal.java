/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.List;
import javax.ejb.Local;
import uma.sii.mcaddss.webscouts.entities.Event;
import uma.sii.mcaddss.webscouts.entities.Group_Scout;

/**
 *
 * @author Nexel
 */
@Local
public interface Group_ManagerLocal {
    public void createGroup(Group_Scout group);
    public void createGroups(List<Group_Scout> group);
    public Group_Scout getGroupScoutById(Long id);
    public List<Group_Scout> getAllGroups();
    public String getDescription(String name);
    public List<Event> getEvents(String name);
}
