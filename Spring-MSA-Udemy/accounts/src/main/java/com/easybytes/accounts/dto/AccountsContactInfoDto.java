package com.easybytes.accounts.dto;

import java.util.List;
import java.util.Map;

// record: 읽기만 가능한 자료형, 기본적으로 getter를 제공하며 변경이 불가능하다.
public record AccountContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {

}
