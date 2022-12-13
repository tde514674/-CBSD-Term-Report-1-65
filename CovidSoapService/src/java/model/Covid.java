/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tinip
 */
@Entity
@Table(name = "COVID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Covid.findAll", query = "SELECT c FROM Covid c"),
    @NamedQuery(name = "Covid.findById", query = "SELECT c FROM Covid c WHERE c.id = :id"),
    @NamedQuery(name = "Covid.findByYears", query = "SELECT c FROM Covid c WHERE c.years = :years"),
    @NamedQuery(name = "Covid.findByWeeknum", query = "SELECT c FROM Covid c WHERE c.weeknum = :weeknum"),
    @NamedQuery(name = "Covid.findByNewCase", query = "SELECT c FROM Covid c WHERE c.newCase = :newCase"),
    @NamedQuery(name = "Covid.findByTotalCase", query = "SELECT c FROM Covid c WHERE c.totalCase = :totalCase"),
    @NamedQuery(name = "Covid.findByNewCaseExcludeabroad", query = "SELECT c FROM Covid c WHERE c.newCaseExcludeabroad = :newCaseExcludeabroad"),
    @NamedQuery(name = "Covid.findByTotalCaseExcludeabroad", query = "SELECT c FROM Covid c WHERE c.totalCaseExcludeabroad = :totalCaseExcludeabroad"),
    @NamedQuery(name = "Covid.findByNewRecovered", query = "SELECT c FROM Covid c WHERE c.newRecovered = :newRecovered"),
    @NamedQuery(name = "Covid.findByTotalRecovered", query = "SELECT c FROM Covid c WHERE c.totalRecovered = :totalRecovered"),
    @NamedQuery(name = "Covid.findByNewDeath", query = "SELECT c FROM Covid c WHERE c.newDeath = :newDeath"),
    @NamedQuery(name = "Covid.findByTotalDeath", query = "SELECT c FROM Covid c WHERE c.totalDeath = :totalDeath"),
    @NamedQuery(name = "Covid.findByCaseForeign", query = "SELECT c FROM Covid c WHERE c.caseForeign = :caseForeign"),
    @NamedQuery(name = "Covid.findByCasePrison", query = "SELECT c FROM Covid c WHERE c.casePrison = :casePrison"),
    @NamedQuery(name = "Covid.findByCaseWalkin", query = "SELECT c FROM Covid c WHERE c.caseWalkin = :caseWalkin"),
    @NamedQuery(name = "Covid.findByCaseNewPrev", query = "SELECT c FROM Covid c WHERE c.caseNewPrev = :caseNewPrev"),
    @NamedQuery(name = "Covid.findByCaseNewDiff", query = "SELECT c FROM Covid c WHERE c.caseNewDiff = :caseNewDiff"),
    @NamedQuery(name = "Covid.findByDeathNewPrev", query = "SELECT c FROM Covid c WHERE c.deathNewPrev = :deathNewPrev"),
    @NamedQuery(name = "Covid.findByDeathNewDiff", query = "SELECT c FROM Covid c WHERE c.deathNewDiff = :deathNewDiff"),
    @NamedQuery(name = "Covid.findByUpdateDate", query = "SELECT c FROM Covid c WHERE c.updateDate = :updateDate")})
public class Covid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEARS")
    private Integer years;
    @Column(name = "WEEKNUM")
    private Integer weeknum;
    @Column(name = "NEW_CASE")
    private Integer newCase;
    @Column(name = "TOTAL_CASE")
    private Integer totalCase;
    @Column(name = "NEW_CASE_EXCLUDEABROAD")
    private Integer newCaseExcludeabroad;
    @Column(name = "TOTAL_CASE_EXCLUDEABROAD")
    private Integer totalCaseExcludeabroad;
    @Column(name = "NEW_RECOVERED")
    private Integer newRecovered;
    @Column(name = "TOTAL_RECOVERED")
    private Integer totalRecovered;
    @Column(name = "NEW_DEATH")
    private Integer newDeath;
    @Column(name = "TOTAL_DEATH")
    private Integer totalDeath;
    @Column(name = "CASE_FOREIGN")
    private Integer caseForeign;
    @Column(name = "CASE_PRISON")
    private Integer casePrison;
    @Column(name = "CASE_WALKIN")
    private Integer caseWalkin;
    @Column(name = "CASE_NEW_PREV")
    private Integer caseNewPrev;
    @Column(name = "CASE_NEW_DIFF")
    private Integer caseNewDiff;
    @Column(name = "DEATH_NEW_PREV")
    private Integer deathNewPrev;
    @Column(name = "DEATH_NEW_DIFF")
    private Integer deathNewDiff;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Covid() {
    }

    public Covid(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Integer weeknum) {
        this.weeknum = weeknum;
    }

    public Integer getNewCase() {
        return newCase;
    }

    public void setNewCase(Integer newCase) {
        this.newCase = newCase;
    }

    public Integer getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(Integer totalCase) {
        this.totalCase = totalCase;
    }

    public Integer getNewCaseExcludeabroad() {
        return newCaseExcludeabroad;
    }

    public void setNewCaseExcludeabroad(Integer newCaseExcludeabroad) {
        this.newCaseExcludeabroad = newCaseExcludeabroad;
    }

    public Integer getTotalCaseExcludeabroad() {
        return totalCaseExcludeabroad;
    }

    public void setTotalCaseExcludeabroad(Integer totalCaseExcludeabroad) {
        this.totalCaseExcludeabroad = totalCaseExcludeabroad;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Integer getNewDeath() {
        return newDeath;
    }

    public void setNewDeath(Integer newDeath) {
        this.newDeath = newDeath;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public Integer getCaseForeign() {
        return caseForeign;
    }

    public void setCaseForeign(Integer caseForeign) {
        this.caseForeign = caseForeign;
    }

    public Integer getCasePrison() {
        return casePrison;
    }

    public void setCasePrison(Integer casePrison) {
        this.casePrison = casePrison;
    }

    public Integer getCaseWalkin() {
        return caseWalkin;
    }

    public void setCaseWalkin(Integer caseWalkin) {
        this.caseWalkin = caseWalkin;
    }

    public Integer getCaseNewPrev() {
        return caseNewPrev;
    }

    public void setCaseNewPrev(Integer caseNewPrev) {
        this.caseNewPrev = caseNewPrev;
    }

    public Integer getCaseNewDiff() {
        return caseNewDiff;
    }

    public void setCaseNewDiff(Integer caseNewDiff) {
        this.caseNewDiff = caseNewDiff;
    }

    public Integer getDeathNewPrev() {
        return deathNewPrev;
    }

    public void setDeathNewPrev(Integer deathNewPrev) {
        this.deathNewPrev = deathNewPrev;
    }

    public Integer getDeathNewDiff() {
        return deathNewDiff;
    }

    public void setDeathNewDiff(Integer deathNewDiff) {
        this.deathNewDiff = deathNewDiff;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Covid)) {
            return false;
        }
        Covid other = (Covid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Covid[ id=" + id + " ]";
    }
    
}
