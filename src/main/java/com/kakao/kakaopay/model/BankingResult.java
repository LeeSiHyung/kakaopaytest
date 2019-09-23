package com.kakao.kakaopay.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class BankingResult <T>{
    @NonNull
    public T result;
}
