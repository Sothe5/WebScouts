/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts.bean;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author zolastro
 */
@Local
public interface SolarRoundLocal {
    public Date getDate();
    void setDate(Date date);
    public void saveDate();
}
