/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CoopApplicant;

/**
 *
 * @author vic
 */
@ManagedBean
@RequestScoped
public class particularData extends particular implements Serializable {

    public particularData() {

    }

    public void scComplete() {
        try {
            CoopApplicant a = (CoopApplicant) emf.createEntityManager().createQuery("SELECT c FROM CoopApplicant c WHERE c.scAcctno = : " + super.getScAccount()).getResultList().get(0);
            super.setfName(a.getFirstName());
            super.setlName(a.getLastName());
            super.setmName(a.getMiddleName());
        } catch (Exception e) {
        }
    }

    public void lnameComplete() {
        try {
            CoopApplicant a = (CoopApplicant) emf.createEntityManager().createQuery("SELECT c FROM CoopApplicant c WHERE UPPER(c.lastName) = : UPPER('" + super.getlName() + "')").getResultList().get(0);
            super.setScAccount(a.getScAcctno());
            super.setfName(a.getFirstName());
            super.setmName(a.getMiddleName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fnameComplete() {
        try {
            CoopApplicant a = (CoopApplicant) emf.createEntityManager().createQuery("SELECT c FROM CoopApplicant c WHERE UPPER(c.firstName) = : UPPER('" + super.getfName() + "')").getResultList().get(0);
            super.setScAccount(a.getScAcctno());
            super.setlName(a.getLastName());
            super.setmName(a.getMiddleName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mnameComplete() {
        try {
            CoopApplicant a = (CoopApplicant) emf.createEntityManager().createQuery("SELECT c FROM CoopApplicant c WHERE UPPER(c.middleName) = : UPPER('" + super.getmName() + "')").getResultList().get(0);
            super.setScAccount(a.getScAcctno());
            super.setfName(a.getFirstName());
            super.setlName(a.getLastName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
