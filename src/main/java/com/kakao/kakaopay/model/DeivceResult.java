package com.kakao.kakaopay.model;

import lombok.*;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
public class DeivceResult<T> {
    @NonNull
    private List<T> devices;
}
