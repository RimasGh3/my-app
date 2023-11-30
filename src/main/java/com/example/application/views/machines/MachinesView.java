package com.example.application.views.machines;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Machines")
@Route(value = "my-view3", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class MachinesView extends Composite<VerticalLayout> {

    public MachinesView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        RouterLink routerLink = new RouterLink();
        H6 h6 = new H6();
        RouterLink routerLink2 = new RouterLink();
        H4 h4 = new H4();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        TextField textField = new TextField();
        ComboBox comboBox = new ComboBox();
        DatePicker datePicker = new DatePicker();
        TimePicker timePicker = new TimePicker();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
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
        routerLink.setRoute(MachinesView.class);
        layoutRow2.setAlignSelf(FlexComponent.Alignment.START, routerLink);
        routerLink.setWidth("min-content");
        routerLink.setHeight("30px");
        h6.setText(">");
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
        h6.setWidth("max-content");
        routerLink2.setText("Machines");
        routerLink2.setRoute(MachinesView.class);
        routerLink2.setWidth("35px");
        routerLink2.setHeight("30px");
        h4.setText("Machines");
        h4.setWidth("max-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.XLARGE);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("80px");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.START);
        textField.setLabel("Machine Name");
        textField.setWidth("min-content");
        comboBox.setLabel("Machine Usage");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        datePicker.setLabel("Date");
        datePicker.setWidth("min-content");
        timePicker.setLabel("Time");
        timePicker.setWidth("min-content");
        buttonPrimary.setText("Search");
        layoutRow3.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Update");
        layoutRow3.setAlignSelf(FlexComponent.Alignment.END, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        multiSelectGrid.setWidth("100%");
        multiSelectGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(multiSelectGrid);
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(routerLink);
        layoutRow2.add(h6);
        layoutRow2.add(routerLink2);
        getContent().add(h4);
        getContent().add(layoutRow3);
        layoutRow3.add(textField);
        layoutRow3.add(comboBox);
        layoutRow3.add(datePicker);
        layoutRow3.add(timePicker);
        layoutRow3.add(buttonPrimary);
        layoutRow3.add(buttonSecondary);
        getContent().add(layoutColumn2);
        layoutColumn2.add(multiSelectGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
