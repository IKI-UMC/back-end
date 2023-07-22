package com.iki.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private boolean isFixed;

    @Column
    private String menuOptionsCategory;

    @Column
    private String menuOptionsContents;

    @Column
    private int menuOptionsPrice;

    @Builder
    public MenuOptions(Long menuOptionsId, boolean isFixed, String menuOptionsCategory, String menuOptionsContents, int menuOptionsPrice) {
        this.menuOptionsId = menuOptionsId;
        this.isFixed = isFixed;
        this.menuOptionsCategory = menuOptionsCategory;
        this.menuOptionsContents = menuOptionsContents;
        this.menuOptionsPrice = menuOptionsPrice;
    }

    public MenuOptions update(boolean isFixed, String menuOptionsCategory, String menuOptionsContents, int menuOptionsPrice) {
        this.isFixed = isFixed;
        this.menuOptionsCategory = menuOptionsCategory;
        this.menuOptionsContents = menuOptionsContents;
        this.menuOptionsPrice = menuOptionsPrice;

        return this;
    }

    public void addMenus(Menus menus) {
        this.menus = menus;
    }
}
