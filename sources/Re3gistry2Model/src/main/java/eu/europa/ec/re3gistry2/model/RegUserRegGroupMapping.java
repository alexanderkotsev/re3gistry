/*
 * Copyright 2007,2016 EUROPEAN UNION
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://ec.europa.eu/isa2/solutions/european-union-public-licence-eupl_en
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 *
 * Date: 2020/05/11
 * Authors:
 * European Commission, Joint Research Centre - jrc-inspire-support@ec.europa.eu
 *
 * This work was supported by the Interoperability solutions for public
 * administrations, businesses and citizens programme (http://ec.europa.eu/isa2)
 * through Action 2016.10: European Location Interoperability Solutions for e-Government (ELISE)
 */
package eu.europa.ec.re3gistry2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "reg_user_reg_group_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegUserRegGroupMapping.findAll", query = "SELECT r FROM RegUserRegGroupMapping r")
    , @NamedQuery(name = "RegUserRegGroupMapping.findByUuid", query = "SELECT r FROM RegUserRegGroupMapping r WHERE r.uuid = :uuid")
    , @NamedQuery(name = "RegUserRegGroupMapping.findByIsGroupadmin", query = "SELECT r FROM RegUserRegGroupMapping r WHERE r.isGroupadmin = :isGroupadmin")
    , @NamedQuery(name = "RegUserRegGroupMapping.findByInsertdate", query = "SELECT r FROM RegUserRegGroupMapping r WHERE r.insertdate = :insertdate")
    , @NamedQuery(name = "RegUserRegGroupMapping.findByEditdate", query = "SELECT r FROM RegUserRegGroupMapping r WHERE r.editdate = :editdate")})
public class RegUserRegGroupMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "is_groupadmin")
    private Boolean isGroupadmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @Column(name = "editdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @JoinColumn(name = "reg_group", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private RegGroup regGroup;
    @JoinColumn(name = "reg_user", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private RegUser regUser;

    public RegUserRegGroupMapping() {
    }

    public RegUserRegGroupMapping(String uuid, Date insertdate) {
        this.uuid = uuid;
        this.insertdate = insertdate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getIsGroupadmin() {
        return isGroupadmin;
    }

    public void setIsGroupadmin(Boolean isGroupadmin) {
        this.isGroupadmin = isGroupadmin;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public RegGroup getRegGroup() {
        return regGroup;
    }

    public void setRegGroup(RegGroup regGroup) {
        this.regGroup = regGroup;
    }

    public RegUser getRegUser() {
        return regUser;
    }

    public void setRegUser(RegUser regUser) {
        this.regUser = regUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof RegUserRegGroupMapping)) {
            return false;
        }
        RegUserRegGroupMapping other = (RegUserRegGroupMapping) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eu.europa.ec.re3gistry2.model.RegUserRegGroupMapping[ uuid=" + uuid + " ]";
    }

}
