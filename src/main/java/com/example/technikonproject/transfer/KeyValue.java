package com.example.technikonproject.transfer;

import lombok.Value;

@Value
public class KeyValue<K, V> {
    K key;
    V value;
}
