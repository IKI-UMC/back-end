package com.iki.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
public class MenuOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuOptionsId;

    @ManyToOne
    @JoinColumn(name = "menusId")
    private Menus menus;

    @Column
    private boolean fixed;

    @Column
    private String menuOptionsCategory;

    @Column
    private String menuOptionsContents;

    @Column
    private int menuOptionsPrice;

    @Builder
    public MenuOptions(boolean fixed, String menuOptionsCategory, String menuOptionsContents, int menuOptionsPrice) {
        this.fixed = fixed;
        this.menuOptionsCategory = menuOptionsCategory;
        this.menuOptionsContents = menuOptionsContents;
        this.menuOptionsPrice = menuOptionsPrice;
    }

    public MenuOptions update(boolean fixed, String menuOptionsCategory, String menuOptionsContents, int menuOptionsPrice) {
        this.fixed = fixed;
        this.menuOptionsCategory = menuOptionsCategory;
        this.menuOptionsContents = menuOptionsContents;
        this.menuOptionsPrice = menuOptionsPrice;

        return this;
    }

    public void addMenus(Menus menus) {
        this.menus = menus;
    }
}
