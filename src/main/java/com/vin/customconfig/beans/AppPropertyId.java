package com.vin.customconfig.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AppPropertyId implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column
    private String application;

    @Column
    private String profile;

    @Column(name = "KY")
    private String key;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppPropertyId)) return false;
        AppPropertyId that = (AppPropertyId) o;
        return Objects.equals(application, that.application) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(application, profile,key);
    }
}
