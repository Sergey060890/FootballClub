package footballclub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class Team
 */
@Getter
@Setter
@Entity
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer team_id;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "coach")
    private String coach;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this)
                != Hibernate.getClass(o)) return false;
        Team team = (Team) o;
        return team_id != null && Objects.equals(team_id, team.team_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

