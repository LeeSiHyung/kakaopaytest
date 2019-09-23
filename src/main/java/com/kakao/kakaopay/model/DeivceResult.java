package com.kakao.kakaopay.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class DeivceResult<T> {
    @NonNull
    private List<T> devices;
}
