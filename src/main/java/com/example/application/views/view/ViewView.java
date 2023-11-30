package com.example.application.views.view;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("View")
@Route(value = "my-view4", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class ViewView extends Composite<VerticalLayout> {

    public ViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        RouterLink routerLink = new RouterLink();
        H6 h6 = new H6();
        RouterLink routerLink2 = new RouterLink();
        H4 h4 = new H4();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Checkbox checkbox = new Checkbox();
        Checkbox checkbox2 = new Checkbox();
        Checkbox checkbox3 = new Checkbox();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid stripedGrid = new Grid(SamplePerson.class);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.SMALL);
        layoutRow2.addClassName(Padding.XSMALL);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        routerLink.setText("Main");
        routerLink.setRoute(ViewView.class);
        routerLink.setWidth("min-content");
        routerLink.setHeight("30px");
        h6.setText(">");
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
        h6.setWidth("max-content");
        routerLink2.setText("View");
        routerLink2.setRoute(ViewView.class);
        routerLink2.setWidth("35px");
        routerLink2.setHeight("30px");
        h4.setText("View");
        h4.setWidth("max-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.XSMALL);
        layoutRow3.addClassName(Padding.XSMALL);
        layoutRow3.setWidth("1037px");
        layoutRow3.setHeight("45px");
        checkbox.setLabel("view Machines");
        checkbox.setWidth("150px");
        checkbox2.setLabel("View Team");
        checkbox2.setWidth("150px");
        checkbox3.setLabel("View Projects");
        checkbox3.setWidth("150px");
        buttonPrimary.setText("View");
        layoutRow3.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        stripedGrid.setWidth("100%");
        stripedGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(stripedGrid);
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(routerLink);
        layoutRow2.add(h6);
        layoutRow2.add(routerLink2);
        getContent().add(h4);
        getContent().add(layoutRow3);
        layoutRow3.add(checkbox);
        layoutRow3.add(checkbox2);
        layoutRow3.add(checkbox3);
        layoutRow3.add(buttonPrimary);
        getContent().add(layoutColumn2);
        layoutColumn2.add(stripedGrid);
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
