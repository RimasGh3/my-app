package com.example.application.views.main;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Main  ")
@Route(value = "my-view2", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class MainView extends Composite<VerticalLayout> {

    public MainView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Avatar avatar = new Avatar();
        H3 h3 = new H3();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H6 h6 = new H6();
        FormLayout formLayout3Col = new FormLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonSecondary = new Button();
        Button buttonSecondary2 = new Button();
        Button buttonSecondary3 = new Button();
        H6 h62 = new H6();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Grid stripedGrid = new Grid(SamplePerson.class);
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        avatar.setName("Firstname Lastname");
        h3.setText("HELLO ADMIN!");
        h3.setWidth("max-content");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h6.setText("chose service");
        h6.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        layoutRow3.setHeightFull();
        formLayout3Col.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        buttonSecondary.setText("Machines");
        buttonSecondary.setWidth("min-content");
        buttonSecondary2.setText("Projects");
        buttonSecondary2.setWidth("min-content");
        buttonSecondary3.setText("Teams");
        buttonSecondary3.setWidth("min-content");
        h62.setText("ACTIVTY");
        h62.setWidth("max-content");
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        stripedGrid.setWidth("100%");
        stripedGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(stripedGrid);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.setHeight("min-content");
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(avatar);
        layoutRow2.add(h3);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h6);
        layoutColumn2.add(formLayout3Col);
        formLayout3Col.add(layoutRow3);
        layoutRow3.add(buttonSecondary);
        layoutRow3.add(buttonSecondary2);
        layoutRow3.add(buttonSecondary3);
        layoutColumn2.add(h62);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(stripedGrid);
        getContent().add(layoutRow5);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
