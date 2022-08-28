package com.team20.t4.plan.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {
    @Enumerated(EnumType.STRING)
    private Gu gu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getGu() == location.getGu();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGu());
    }
}
