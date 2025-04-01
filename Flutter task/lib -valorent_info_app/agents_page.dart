import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class AgentsPage extends StatefulWidget {
  const AgentsPage({super.key});

  @override
  _AgentsPageState createState() => _AgentsPageState();
}

class _AgentsPageState extends State<AgentsPage> {
  List agents = [];
  List filteredAgents = [];
  bool isLoading = true;
  TextEditingController searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    fetchAgents();
  }

  Future<void> fetchAgents() async {
    const url = 'https://valorant-api.com/v1/agents?isPlayableCharacter=true';
    try {
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        setState(() {
          agents = data['data'];
          filteredAgents = agents;
          isLoading = false;
        });
      } else {
        throw Exception('Failed to load agents');
      }
    } catch (e) {
      print('Error: $e');
      setState(() {
        isLoading = false;
      });
    }
  }

  void filterAgents(String query) {
    setState(() {
      filteredAgents = agents
          .where((agent) => agent['displayName'].toLowerCase().contains(query.toLowerCase()))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Valorant Agents', style: TextStyle(color: Colors.white)),
        backgroundColor: Colors.black,
      ),
      body: Stack(
        children: [
          Container(
            decoration: const BoxDecoration(
              image: DecorationImage(
                image: NetworkImage('https://media.valorant-api.com/maps/d960549e-485c-e861-8d71-aa9d1aed12a2/listviewicontall.png'),
                fit: BoxFit.cover,
              ),
            ),
          ),
          Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(10.0),
                child: TextField(
                  controller: searchController,
                  onChanged: filterAgents,
                  decoration: InputDecoration(
                    hintText: 'Search Agents...',
                    prefixIcon: const Icon(Icons.search, color: Colors.white),
                    filled: true,
                    fillColor: Colors.black.withOpacity(0.7),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10.0),
                      borderSide: BorderSide.none,
                    ),
                    hintStyle: const TextStyle(color: Colors.white70),
                  ),
                  style: const TextStyle(color: Colors.white),
                ),
              ),
              Expanded(
                child: isLoading
                    ? const Center(child: CircularProgressIndicator())
                    : ListView.builder(
                        itemCount: filteredAgents.length,
                        itemBuilder: (context, index) {
                          final agent = filteredAgents[index];
                          return Card(
                            color: Colors.black.withOpacity(0.7),
                            margin: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                            child: ListTile(
                              leading: CircleAvatar(
                                backgroundImage: NetworkImage(agent['displayIcon']),
                              ),
                              title: Text(
                                agent['displayName'],
                                style: const TextStyle(color: Colors.white, fontSize: 18),
                              ),
                              onTap: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) => AgentDetailPage(agent: agent),
                                  ),
                                );
                              },
                            ),
                          );
                        },
                      ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class AgentDetailPage extends StatelessWidget {
  final Map agent;

  const AgentDetailPage({super.key, required this.agent});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(agent['displayName'], style: const TextStyle(color: Colors.white)),
        backgroundColor: Colors.black,
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.network(agent['fullPortrait'] ?? agent['displayIcon'], height: 300),
              const SizedBox(height: 20),
              Text(agent['displayName'], style: const TextStyle(fontSize: 32, fontWeight: FontWeight.bold, color: Colors.white)),
              const SizedBox(height: 10),
              Text('Role: ${agent['role']?['displayName'] ?? 'Unknown'}', style: const TextStyle(fontSize: 18, color: Colors.white)),
              const SizedBox(height: 20),
              Text(agent['description'] ?? 'No Description Available', textAlign: TextAlign.center, style: const TextStyle(fontSize: 16, color: Colors.white)),
              const SizedBox(height: 20),
              const Text('Abilities', style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.white)),
              const SizedBox(height: 10),
              if (agent['abilities'] != null)
                ...agent['abilities'].map<Widget>((ability) => Padding(
                      padding: const EdgeInsets.symmetric(vertical: 8.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            children: [
                              if (ability['displayIcon'] != null)
                                Image.network(ability['displayIcon'], height: 40, width: 40),
                              const SizedBox(width: 10),
                              Text(
                                ability['displayName'] ?? 'Unknown Ability',
                                style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white),
                              ),
                            ],
                          ),
                          const SizedBox(height: 5),
                          Text(ability['description'] ?? 'No description available', style: const TextStyle(color: Colors.white)),
                        ],
                      ),
                    ))
            ],
          ),
        ),
      ),
      backgroundColor: Colors.black,
    );
  }
}
