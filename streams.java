List<String> result = list.stream()
                          .filter(s -> s.length() > 3)
                          .map(String::toUpperCase)
                          .distinct()
                          .sorted()
                          .collect(Collectors.toList());
