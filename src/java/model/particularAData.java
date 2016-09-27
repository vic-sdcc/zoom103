/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.particular;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author vic
 */
@ManagedBean
@RequestScoped
public class particularAData extends particular implements Serializable {

    public particularAData() {

    }

    public List<Integer> scAComplete(String query) {
        return emf.createEntityManager().createQuery("SELECT c.scAcctno FROM CoopApplicant c "
                + "WHERE CONCAT(c.scAcctno,'') LIKE '%" + query + "%'").getResultList();
    }

    public List<String> lnAComplete(String query) {
        return emf.createEntityManager().createQuery("SELECT c.lastName FROM CoopApplicant c "
                + "WHERE UPPER(c.lastName) LIKE UPPER('%" + query + "%')").getResultList();
    }

    public List<String> fnAComplete(String query) {
        return emf.createEntityManager().createQuery("SELECT c.firstName FROM CoopApplicant c "
                + "WHERE UPPER(c.firstName) LIKE UPPER('%" + query + "%')").getResultList();
    }

    public List<String> mnAComplete(String query) {
        return emf.createEntityManager().createQuery("SELECT c.middleName FROM CoopApplicant c "
                + "WHERE UPPER(c.middleName) LIKE UPPER('%" + query + "%')").getResultList();
    }

}
