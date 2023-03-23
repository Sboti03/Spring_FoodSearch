package hu.petrik.foodsearch.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foods")
@Entity
@Builder
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer foodId;

    @Column(unique = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column
    private Integer calorie;

    @Column
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column
    private Integer perUnit;
}
