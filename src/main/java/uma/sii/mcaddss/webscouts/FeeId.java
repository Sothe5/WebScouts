/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.sii.mcaddss.webscouts;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 * This embeddable class is the composite PK of Fee.class
 * getters and setters omitted since both id's are PK on their respective tables
 * @author dan147
 */
@Embeddable
public class FeeId implements Serializable {
 
    private Long userscout;
    private Long event;

    public FeeId(){
    }
    
    public FeeId(Long userscout, Long event){
        this.userscout = userscout;
        this.event = event;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.userscout, this.event);
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof FeeId)) return false;
        FeeId other = (FeeId) o;
        return Objects.equals(this.userscout, other.userscout) &&
                Objects.equals(this.event, other.event);
    }
}
