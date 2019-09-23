package com.kakao.kakaopay.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private String userId;
    @NonNull
    private String userPasswd;
    private String userToken;
}
