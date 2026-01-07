package com.lokidev.oneliner.service;

import com.lokidev.oneliner.AbstractIntegrationTest;
import com.lokidev.oneliner.entity.OneLiner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OneLinerServiceIT extends AbstractIntegrationTest {

    @Autowired
    private OneLinerService oneLinerService;

    @Test
    public void save_ValidOneLiner_ReturnsPersistedEntityWithId(){
        OneLiner validOneLiner = new OneLiner("Life is code","Gemini","Coding");

        OneLiner result = oneLinerService.save(validOneLiner);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
        assertThat(result.getAuthor()).isEqualTo("Gemini");
    }

    @Test
    public void save_DuplicateUniqueKey_ThrowsDataIntegrityException() {
        // Given
        OneLiner first = new OneLiner("Life is code one", "Gemini", "Coding");
        OneLiner duplicate = new OneLiner("Life is code one", "Gemini", "Coding");

        oneLinerService.save(first);

        // When & Then
        // We use assertThatThrownBy to properly catch the exception
        assertThatThrownBy(() -> oneLinerService.save(duplicate))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
