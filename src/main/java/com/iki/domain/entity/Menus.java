package com.iki.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menusId;

    @Column
    private String menusCategory;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Owner owner;

    @Column
    private String menusName;

    @Column
    private int menusPrice;

    @Column
    private boolean soldOut;

    @OneToMany(mappedBy = "menus", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<MenuOptions> menuOptionsList = new ArrayList<>();

    @Builder
    public Menus(String menusCategory, String menusName, int menusPrice){
        this.menusCategory = menusCategory;
        this.menusName = menusName;
        this.menusPrice = menusPrice;
        this.soldOut = false;
    }

    public Menus update(String menuCategory, String menusName, int menusPrice, boolean soldOut) {
        this.menusCategory = menuCategory;
        this.menusName = menusName;
        this.menusPrice = menusPrice;
        this.soldOut = soldOut;

        return this;
    }

    public void addOwner(Owner owner) {
        this.owner = owner;
    }

    public void addMenuOptions(MenuOptions menuOptions) {
        this.menuOptionsList.add(menuOptions);
    }
}
