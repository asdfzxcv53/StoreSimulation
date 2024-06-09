package com.example.store;

import com.example.store.sequence.CodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CodeResetTask {

    private final CodeSequence codeSequence;

    @Autowired
    public CodeResetTask(CodeSequence codeSequence) {
        this.codeSequence = codeSequence;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void resetCode() {
        codeSequence.ResetCode();
    }
}
