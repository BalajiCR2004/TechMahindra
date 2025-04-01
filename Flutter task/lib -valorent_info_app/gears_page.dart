import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class GearsPage extends StatefulWidget {
  const GearsPage({super.key});

  @override
  _GearsPageState createState() => _GearsPageState();
}

class _GearsPageState extends State<GearsPage> {
  List gears = [];
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    fetchGears();
  }

  Future<void> fetchGears() async {
    const url = 'https://valorant-api.com/v1/gear';
    try {
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        setState(() {
          gears = data['data'];
          isLoading = false;
        });
      } else {
        throw Exception('Failed to load gears');
      }
    } catch (e) {
      print('Error: $e');
      setState(() {
        isLoading = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: const Text('Valorant Gears', style: TextStyle(color: Colors.white)),
        backgroundColor: Colors.black,
      ),
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: NetworkImage('https://media.valorant-api.com/maps/690b3ed2-4dff-945b-8223-6da834e30d24/listviewicontall.png'),
            fit: BoxFit.cover,
            colorFilter: ColorFilter.mode(Colors.black54, BlendMode.darken),
          ),
        ),
        child: isLoading
            ? const Center(child: CircularProgressIndicator(color: Colors.white))
            : ListView.builder(
                itemCount: gears.length,
                itemBuilder: (context, index) {
                  final gear = gears[index];
                  return Card(
                    color: Colors.black.withOpacity(0.8),
                    margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                    child: ListTile(
                      leading: Container(
                        width: 50,
                        height: 50,
                        decoration: BoxDecoration(
                          color: Colors.black, // 🔹 Background for transparent icons
                          shape: BoxShape.circle,
                        ),
                        child: ClipOval(
                          child: gear['displayIcon'] != null
                              ? Image.network(
                                  gear['displayIcon'],
                                  fit: BoxFit.contain,
                                  errorBuilder: (context, error, stackTrace) =>
                                      const Icon(Icons.broken_image, color: Colors.white),
                                )
                              : const Icon(Icons.device_hub, color: Colors.white),
                        ),
                      ),
                      title: Text(
                        gear['displayName'] ?? 'Unknown',
                        style: const TextStyle(color: Colors.white),
                      ),
                      onTap: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => GearDetailPage(gear: gear),
                          ),
                        );
                      },
                    ),
                  );
                },
              ),
      ),
    );
  }
}

class GearDetailPage extends StatelessWidget {
  final Map gear;

  const GearDetailPage({super.key, required this.gear});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text(gear['displayName'] ?? 'Unknown', style: const TextStyle(color: Colors.white)),
        backgroundColor: Colors.black,
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              if (gear['displayIcon'] != null)
                Container(
                  padding: const EdgeInsets.all(10),
                  decoration: BoxDecoration(
                    color: Colors.black, // 🔹 Added black background
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Image.network(
                    gear['displayIcon'],
                    height: 300,
                    fit: BoxFit.contain,
                  ),
                ),
              const SizedBox(height: 20),
              Text(
                gear['displayName'] ?? 'Unknown',
                style: const TextStyle(fontSize: 32, fontWeight: FontWeight.bold, color: Colors.white),
              ),
              const SizedBox(height: 10),
              Text(
                'Category: ${gear['shopData']?['categoryText'] ?? 'Unknown'}',
                style: const TextStyle(fontSize: 18, color: Colors.grey),
              ),
              const SizedBox(height: 20),
              Text(
                gear['description'] ?? 'No Description Available',
                textAlign: TextAlign.center,
                style: const TextStyle(fontSize: 16, color: Colors.grey),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
