package com.lokidev.oneliner.repository;

import com.lokidev.oneliner.AbstractIntegrationTest;
import com.lokidev.oneliner.entity.OneLiner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class OneLinerRepositoryIT extends AbstractIntegrationTest {

    @Autowired
    private OneLinerRepository oneLinerRepository;


    @Test
    public void shouldSaveAndFindByContext(){
        OneLiner oneliner=  new OneLiner(
                "Simplicity is the ultimate sophistication",
                "Leonardo da Vinci",
                "design"
        );
        oneLinerRepository.save(oneliner);
        List<OneLiner> result = oneLinerRepository.findByContextIgnoreCase("DeSign");
        assertThat(result).hasSize(1);
        assertThat(result.getFirst().getAuthor()).isEqualTo(oneliner.getAuthor());
    }
}
