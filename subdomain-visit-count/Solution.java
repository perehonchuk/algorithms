class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
    	Map<String, Integer> result = new HashMap<>();
    	for (String d: cpdomains) {
    		int count = count(d);
    		List<String> domains = allDomains(d);
    		for (String domain: domains) {
    			result.compute(domain, (k ,v) -> v == null? count: v + count);
    		}
    	}

    	return result.entrySet().stream().map(e -> render(e.getKey(), e.getValue())).collect(Collectors.toList());
    }

    private List<String> allDomains(String input) {
    	String d = input.split(" ")[1];
    	List<String> result = new ArrayList<>();
    	result.add(d);
    	int index = d.indexOf(".");
    	while (index != -1) {
    		d = d.substring(index + 1);
    		result.add(d);
    		index = d.indexOf(".");
    	}
    	return result;
    }

    private int count(String input) {
    	return Integer.valueOf(input.split(" ")[0]);
    }

    private String render(String domain, int count) {
    	return String.format("%d %s", count, domain);
    }
}
