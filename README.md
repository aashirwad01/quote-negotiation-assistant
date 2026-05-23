# 📦 Quote Negotiation Assistant for Industrial Supply Chains

A backend simulation of how industrial B2B suppliers (like Fastenal, Grainger, etc.) process quote requests — using both rule-based pricing and LLM-driven overrides.

---

## 🎯 Project Goal

Simulate a realistic quote negotiation engine for supply chain B2B pricing by:

- Applying business rules (tier, region, urgency, volume)
- Parsing natural language quote notes with LLMs (e.g., "price match with Amazon")
- Returning a final, auditable quote output
- (Optional later) Supporting frontend inputs via CSV, API, or form

---
<img width="1373" height="724" alt="image" src="https://github.com/user-attachments/assets/4a67331e-0210-425e-bd7a-af72cd5ccf3d" />

<img width="1382" height="693" alt="image" src="https://github.com/user-attachments/assets/3de2fb43-e01e-41b4-98ed-b0a56c4b353e" />


---

## ⚙️ Tech Stack

| Layer      | Tech                      |
|------------|---------------------------|
| Backend    | Java 17, Spring Boot 3    |
| LLM        | OpenAI / Mistral (via API)|
| Patterns   | Strategy, Adapter         |
| Persistence| PostgreSQL (or H2 for demo) |
| API Docs   | Postman / Swagger         |

---

## 🧱 Architecture Overview

```plaintext
FormRequestDTO (user input) + LLMOverrideDTO (parsed suggestion)
        ↓
FormInputAdapter implements QuoteInput
        ↓
QuoteRuleEngine (consumes QuoteInput)
        ↓
Quote + QuoteAuditLog persisted
        ↓
QuoteResponseDTO returned
