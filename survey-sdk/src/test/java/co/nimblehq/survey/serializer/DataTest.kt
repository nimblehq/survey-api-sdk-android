package co.nimblehq.survey.serializer

const val JSON_SURVEY_DETAIL_TEST: String = "{\n" +
    "  \"data\": {\n" +
    "    \"id\": \"d5de6a8f8f5f1cfe51bc\",\n" +
    "    \"type\": \"survey\",\n" +
    "    \"attributes\": {\n" +
    "      \"title\": \"Scarlett Bangkok\",\n" +
    "      \"description\": \"We'd love ot hear from you!\",\n" +
    "      \"thank_email_above_threshold\": \"Test1\",\n" +
    "      \"thank_email_below_threshold\": \"Test2\",\n" +
    "      \"is_active\": true,\n" +
    "      \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
    "      \"created_at\": \"2017-01-23T07:48:12.991Z\",\n" +
    "      \"active_at\": \"2015-10-08T07:04:00.000Z\",\n" +
    "      \"inactive_at\": null,\n" +
    "      \"survey_type\": \"Restaurant\"\n" +
    "    },\n" +
    "    \"relationships\": {\n" +
    "      \"questions\": {\n" +
    "        \"data\": [\n" +
    "          {\n" +
    "            \"id\": \"d3afbcf2b1d60af845dc\",\n" +
    "            \"type\": \"question\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"id\": \"940d229e4cd87cd1e202\",\n" +
    "            \"type\": \"question\"\n" +
    "          }\n" +
    "        ]\n" +
    "      }\n" +
    "    }\n" +
    "  },\n" +
    "  \"included\": [\n" +
    "    {\n" +
    "      \"id\": \"d3afbcf2b1d60af845dc\",\n" +
    "      \"type\": \"question\",\n" +
    "      \"attributes\": {\n" +
    "        \"text\": \"\\nThank you for visiting Scarlett!\\n Please take a moment to share your feedback.\",\n" +
    "        \"help_text\": null,\n" +
    "        \"display_order\": 0,\n" +
    "        \"short_text\": \"introduction\",\n" +
    "        \"pick\": \"none\",\n" +
    "        \"display_type\": \"intro\",\n" +
    "        \"is_mandatory\": false,\n" +
    "        \"correct_answer_id\": null,\n" +
    "        \"facebook_profile\": null,\n" +
    "        \"twitter_profile\": null,\n" +
    "        \"image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/2001ebbfdcbf6c00c757_\",\n" +
    "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
    "        \"cover_image_opacity\": 0.6,\n" +
    "        \"cover_background_color\": null,\n" +
    "        \"is_shareable_on_facebook\": false,\n" +
    "        \"is_shareable_on_twitter\": false,\n" +
    "        \"font_face\": null,\n" +
    "        \"font_size\": null,\n" +
    "        \"tag_list\": \"\"\n" +
    "      },\n" +
    "      \"relationships\": {\n" +
    "        \"answers\": {\n" +
    "          \"data\": []\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"575db8c074601994bde3\",\n" +
    "      \"type\": \"answer\",\n" +
    "      \"attributes\": {\n" +
    "        \"text\": \"Email \",\n" +
    "        \"help_text\": null,\n" +
    "        \"input_mask_placeholder\": \"you@example.com\",\n" +
    "        \"short_text\": \"answer_6\",\n" +
    "        \"is_mandatory\": false,\n" +
    "        \"is_customer_first_name\": false,\n" +
    "        \"is_customer_last_name\": false,\n" +
    "        \"is_customer_title\": false,\n" +
    "        \"is_customer_email\": true,\n" +
    "        \"prompt_custom_answer\": false,\n" +
    "        \"weight\": null,\n" +
    "        \"display_order\": 2,\n" +
    "        \"display_type\": \"default\",\n" +
    "        \"input_mask\": \"[\\\\.\\\\-_\\\\+a-zA-Z0-9]+@[\\\\-\\\\a-zA-Z0-9]+(?:\\\\.[\\\\-a-zA-Z0-9]+)+\",\n" +
    "        \"date_constraint\": null,\n" +
    "        \"default_value\": null,\n" +
    "        \"response_class\": \"string\",\n" +
    "        \"reference_identifier\": null,\n" +
    "        \"score\": null,\n" +
    "        \"alerts\": []\n" +
    "      }\n" +
    "    }\n" +
    "  ]\n" +
    "}"

const val JSON_SURVEY_LIST_TEST = "{\n" +
    "  \"data\": [\n" +
    "    {\n" +
    "      \"id\": \"d5de6a8f8f5f1cfe51bc\",\n" +
    "      \"type\": \"survey\",\n" +
    "      \"attributes\": {\n" +
    "        \"title\": \"Scarlett Bangkok\",\n" +
    "        \"description\": \"We'd love ot hear from you!\",\n" +
    "        \"thank_email_above_threshold\": \"Test1\",\n" +
    "        \"thank_email_below_threshold\": \"Test2\",\n" +
    "        \"is_active\": true,\n" +
    "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
    "        \"created_at\": \"2017-01-23T07:48:12.991Z\",\n" +
    "        \"active_at\": \"2015-10-08T07:04:00.000Z\",\n" +
    "        \"inactive_at\": null,\n" +
    "        \"survey_type\": \"Restaurant\"\n" +
    "      },\n" +
    "      \"relationships\": {\n" +
    "        \"questions\": {\n" +
    "          \"data\": [\n" +
    "            {\n" +
    "              \"id\": \"d3afbcf2b1d60af845dc\",\n" +
    "              \"type\": \"question\"\n" +
    "            },\n" +
    "            {\n" +
    "              \"id\": \"940d229e4cd87cd1e202\",\n" +
    "              \"type\": \"question\"\n" +
    "            },\n" +
    "            {\n" +
    "              \"id\": \"4372463ce56db58c0983\",\n" +
    "              \"type\": \"question\"\n" +
    "            }\n" +
    "          ]\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +
    "    {\n" +
    "      \"id\": \"ed1d4f0ff19a56073a14\",\n" +
    "      \"type\": \"survey\",\n" +
    "      \"attributes\": {\n" +
    "        \"title\": \"ibis Bangkok Riverside\",\n" +
    "        \"description\": \"We'd love to hear from you!\",\n" +
    "        \"thank_email_above_threshold\": \"Dear {name},<br /><br />Thank you for visiting Beach Republic and for taking the time to complete our brief survey. We are thrilled that you enjoyed your time with us! If you have a moment, we would be greatly appreciate it if you could leave a short review on <a href=\\\"http://www.tripadvisor.com/Hotel_Review-g1188000-d624070-Reviews-Beach_Republic_The_Residences-Lamai_Beach_Maret_Ko_Samui_Surat_Thani_Province.html\\\">TripAdvisor</a>. It helps to spread the word and let others know about the Beach Republic Revolution!<br /><br />Thank you again and we look forward to welcoming you back soon.<br /><br />Sincerely,<br /><br />Beach Republic Team\",\n" +
    "        \"thank_email_below_threshold\": \"Dear {name},<br /><br />Thank you for visiting Beach Republic and for taking the time to complete our brief survey. We are constantly striving to improve and your feedback allows us to help improve the experience for you on your next visit. Each survey is read individually by senior staff and discussed with the team in daily meetings.&nbsp;<br /><br />Thank you again and we look forward to welcoming you back soon.<br /><br />Sincerely,<br /><br />Beach Republic Team\",\n" +
    "        \"is_active\": true,\n" +
    "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/287db81c5e4242412cc0_\",\n" +
    "        \"created_at\": \"2017-01-23T03:32:24.585Z\",\n" +
    "        \"active_at\": \"2016-01-22T04:12:00.000Z\",\n" +
    "        \"inactive_at\": null,\n" +
    "        \"survey_type\": \"Hotel\"\n" +
    "      },\n" +
    "      \"relationships\": {\n" +
    "        \"questions\": {\n" +
    "          \"data\": [\n" +
    "            {\n" +
    "              \"id\": \"fa385b75617d98e069a3\",\n" +
    "              \"type\": \"question\"\n" +
    "            },\n" +
    "            {\n" +
    "              \"id\": \"2ecd2926eb02e7a58024\",\n" +
    "              \"type\": \"question\"\n" +
    "            }\n" +
    "          ]\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "  ],\n" +
    "  \"meta\": {\n" +
    "    \"page\": 1,\n" +
    "    \"pages\": 10,\n" +
    "    \"page_size\": 2,\n" +
    "    \"records\": 20\n" +
    "  }\n" +
    "}"
