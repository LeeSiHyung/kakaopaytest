package com.kakao.kakaopay.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class BankingResult <T>{
    @NonNull
    public T result;
}
