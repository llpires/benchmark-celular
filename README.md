# 📱 Benchmark do Celular

<p align="center">
  <img src="icons/icon-192.png" width="120" alt="Logo">
</p>

<p align="center">
  <strong>Aplicativo de benchmark para Android</strong><br>
  Análise de performance em tempo real do seu dispositivo
</p>

## 📋 Sobre

Este projeto é um **Progressive Web App (PWA)** que executa testes de performance diretamente no navegador do dispositivo. Ele inclui uma GitHub Action que compila automaticamente um APK Android a cada push na branch `main`.

### Testes incluídos:

| Teste | Descrição |
|-------|-----------|
| ⚡ **CPU** | Single-core e Multi-core via Web Workers |
| 🧠 **Memória RAM** | Leitura, escrita e latência |
| 🎮 **GPU** | FPS e tempo de render via WebGL |
| 💾 **Disco** | IOPS e velocidade de leitura/escrita |
| 🌐 **Rede** | Download, upload e latência |
| 🖥️ **Display** | DPI, taxa de atualização e profundidade de cor |
| 🌍 **Web** | Performance de render e cálculos JS |
| 🌡️ **Térmico** | Sustentabilidade e throttling |

## 🚀 Como usar o APK

### Opção 1: Download via Releases
1. Acesse a aba **Releases** deste repositório
2. Baixe o arquivo `.apk` mais recente
3. Instale no Android (permita "fontes desconhecidas" se necessário)

### Opção 2: Build manual
O APK é gerado automaticamente a cada push. Acesse **Actions** → último workflow → **Artifacts**.

## 🛠️ Desenvolvimento local

```bash
# Clone o repositório
git clone https://github.com/llpires/benchmark-celular.git
cd benchmark-celular

# Sirva localmente (Python)
python3 -m http.server 8080

# Ou com Node.js
npx serve .
```

Acesse `http://localhost:8080` no navegador.

## 📦 Build do APK

O APK é gerado automaticamente via **GitHub Actions** usando um wrapper de WebView nativo para Android.

Para build local manual:

```bash
# 1. Setup Android SDK
# 2. Execute o workflow manualmente via gh:
gh workflow run build-apk.yml
```

## 📊 Score

O score geral é calculado com pesos:
- CPU: 25%
- GPU: 20%
- Memória: 15%
- Rede: 10%
- Disco: 10%
- Web: 10%
- Display: 5%
- Térmico: 5%

## 📄 Licença

MIT License
