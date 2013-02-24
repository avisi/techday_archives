package nl.avisi.shared.domain;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Bindable
@Portable
public class Pizza {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 4)
    private String name;

    public Pizza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
