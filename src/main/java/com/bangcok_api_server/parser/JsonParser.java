package com.bangcok_api_server.parser;

import java.util.ArrayList;

public interface JsonParser {
	ArrayList<Object> parse(String jsonString);
}