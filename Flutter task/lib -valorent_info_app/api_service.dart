import 'dart:convert';
import 'package:http/http.dart' as http;

Future<List<dynamic>> fetchAgents() async {
  final response = await http.get(Uri.parse('https://valorant-api.com/v1/agents'));

  if (response.statusCode == 200) {
    final data = jsonDecode(response.body);
    return data['data'];
  } else {
    throw Exception('Failed to load agents');
  }
}
