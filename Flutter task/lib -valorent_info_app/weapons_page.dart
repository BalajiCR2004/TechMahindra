import 'package:flutter/material.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class WeaponsPage extends StatefulWidget {
  const WeaponsPage({super.key});

  @override
  State<WeaponsPage> createState() => _WeaponsPageState();
}

class _WeaponsPageState extends State<WeaponsPage> {
  List<dynamic> weapons = [];
  List<dynamic> filteredWeapons = [];
  bool isLoading = true;
  TextEditingController searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    fetchWeapons();
  }

  Future<void> fetchWeapons() async {
    const url = 'https://valorant-api.com/v1/weapons';
    try {
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        setState(() {
          weapons = data['data'];
          filteredWeapons = weapons;
          isLoading = false;
        });
      } else {
        throw Exception('Failed to load weapons data');
      }
    } catch (e) {
      setState(() {
        isLoading = false;
      });
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: ${e.toString()}')),
      );
    }
  }

  void filterWeapons(String query) {
    setState(() {
      filteredWeapons = weapons
          .where((weapon) => weapon['displayName']
              .toLowerCase()
              .contains(query.toLowerCase()))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Valorant Weapons', style: TextStyle(color: Colors.white)),
        backgroundColor: Colors.black,
      ),
      body: Stack(
        children: [
          Container(
            decoration: const BoxDecoration(
              image: DecorationImage(
                image: NetworkImage('https://media.valorant-api.com/maps/2fb9a4fd-47b8-4e7d-a969-74b4046ebd53/listviewicontall.png'),
                fit: BoxFit.cover,
              ),
            ),
          ),
          Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: TextField(
                  controller: searchController,
                  onChanged: filterWeapons,
                  style: const TextStyle(color: Colors.white),
                  decoration: InputDecoration(
                    hintText: 'Search weapons...',
                    hintStyle: const TextStyle(color: Colors.white54),
                    filled: true,
                    fillColor: Colors.black.withOpacity(0.7),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                      borderSide: BorderSide.none,
                    ),
                    prefixIcon: const Icon(Icons.search, color: Colors.white),
                  ),
                ),
              ),
              Expanded(
                child: isLoading
                    ? const Center(child: CircularProgressIndicator())
                    : ListView.builder(
                        itemCount: filteredWeapons.length,
                        itemBuilder: (context, index) {
                          final weapon = filteredWeapons[index];
                          return Card(
                            color: Colors.black.withOpacity(0.7),
                            margin: const EdgeInsets.all(8.0),
                            child: ListTile(
                              leading: weapon['displayIcon'] != null
                                  ? Image.network(weapon['displayIcon'], width: 50)
                                  : const Icon(Icons.sports_esports, color: Colors.white),
                              title: Text(
                                weapon['displayName'] ?? 'Unknown Weapon',
                                style: const TextStyle(color: Colors.white),
                              ),
                              onTap: () => showWeaponDetails(context, weapon),
                            ),
                          );
                        },
                      ),
              ),
            ],
          ),
        ],
      ),
      backgroundColor: Colors.black,
    );
  }

  void showWeaponDetails(BuildContext context, dynamic weapon) {
    final weaponStats = weapon['weaponStats'];
    final damageRanges = weaponStats?['damageRanges'] ?? [];

    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        backgroundColor: Colors.black,
        title: Text(
          weapon['displayName'],
          style: const TextStyle(color: Colors.white),
        ),
        content: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              if (weapon['displayIcon'] != null)
                Image.network(weapon['displayIcon'], height: 150),
              const SizedBox(height: 10),
              Text('Number of Bullets: ${weaponStats?['magazineSize'] ?? 'N/A'}',
                  style: const TextStyle(color: Colors.white)),
              Text('Fire Rate: ${weaponStats?['fireRate'] ?? 'N/A'} per second',
                  style: const TextStyle(color: Colors.white)),
              Text('Reload Time: ${weaponStats?['reloadTimeSeconds'] ?? 'N/A'} seconds',
                  style: const TextStyle(color: Colors.white)),
              const SizedBox(height: 10),
              const Text('Damage Information:',
                  style: TextStyle(fontWeight: FontWeight.bold, color: Colors.white)),
              for (var range in damageRanges)
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Range: ${range['rangeStartMeters']}m - ${range['rangeEndMeters']}m',
                        style: const TextStyle(color: Colors.white)),
                    Text('Head Damage: ${range['headDamage']}',
                        style: const TextStyle(color: Colors.white)),
                    Text('Body Damage: ${range['bodyDamage']}',
                        style: const TextStyle(color: Colors.white)),
                    Text('Leg Damage: ${range['legDamage']}',
                        style: const TextStyle(color: Colors.white)),
                    const Divider(color: Colors.white),
                  ],
                ),
            ],
          ),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Close', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }
}